package com.himanshu03vsk.studentglobek.presentation.activities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.himanshu03vsk.studentglobek.domain.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SearchPeersViewModel : ViewModel() {

    private val _searchResults = MutableStateFlow<List<User>>(emptyList())
    val searchResults: StateFlow<List<User>> = _searchResults

    private val db = FirebaseFirestore.getInstance()

    fun searchPeers(query: String) {
        viewModelScope.launch {
            db.collection("users")
                .orderBy("name")
                .startAt(query.toTitleCase())
                .endAt(query.toTitleCase() + "\uf8ff")
                .get()
                .addOnSuccessListener { documents ->
                    val users = documents.mapNotNull { it.toObject(User::class.java) }
                    _searchResults.value = users
                }
                .addOnFailureListener {
                    _searchResults.value = emptyList()
                }
        }
    }

    fun getAllUsers() {
        viewModelScope.launch {
            db.collection("users")
                .orderBy("name")
                .get()
                .addOnSuccessListener { documents ->
                    val users = documents.mapNotNull { it.toObject(User::class.java) }
                    _searchResults.value = users
                }
                .addOnFailureListener {
                    _searchResults.value = emptyList()
                }
        }
    }

    private fun String.toTitleCase(): String {
        return this.split(" ")
            .joinToString(" ") { it.replaceFirstChar { char -> char.uppercase() } }
    }

}
