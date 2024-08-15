package com.prabhakar.jantagrocery.viewmodels

import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.prabhakar.jantagrocery.model.ProductModel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class UserViewModel : ViewModel() {
    fun fetchAllProduct(): Flow<List<ProductModel>> = callbackFlow {
        val db = FirebaseDatabase.getInstance().getReference("Admin").child("All Products")

        val eventListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val products = ArrayList<ProductModel>()
                for (product in snapshot.children) {
                    val data = product.getValue(ProductModel::class.java)
                    products.add(data!!)
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }

        }

        db.addValueEventListener(eventListener)

        awaitClose { db.removeEventListener(eventListener) }

    }

}