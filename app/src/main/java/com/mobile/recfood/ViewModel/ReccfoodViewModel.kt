package com.mobile.recfood.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.recfood.model.Recipe
import com.mobile.recfood.network.ApiService
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ReccfoodViewModel(private val apiService: ApiService) : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    private val _newRecipeList = MutableStateFlow<List<Recipe>>(emptyList())
    val recipeList: StateFlow<List<Recipe>> = _newRecipeList

//    // State untuk detail resep tertentu
//    private val _recipeDetails = MutableStateFlow<RecipeDetails?>(null)
//    val recipeDetails: StateFlow<RecipeDetails?> = _recipeDetails
//
//    // State untuk hasil pencarian
//    private val _searchResults = MutableStateFlow<List<Recipe>>(emptyList())
//    val searchResults: StateFlow<List<Recipe>> = _searchResults
//
//    // State untuk menampilkan loading atau error status
//    private val _isLoading = MutableStateFlow(false)
//    val isLoading: StateFlow<Boolean> = _isLoading
//
//    private val _errorMessage = MutableStateFlow<String?>(null)
//    val errorMessage: StateFlow<String?> = _errorMessage

    // Fungsi untuk mengambil daftar resep dari API
    fun fetchNewRecipe() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            try {
                val response = apiService.getRecipeList()
                _newRecipeList.value = response.result.recipe_list
                Log.d("API", "Response: $response")
            } catch (e: Exception) {
                _errorMessage.value = "Error fetching recipe list"
            } finally {
                _isLoading.value = false
            }
        }
    }
//
//    // Fungsi untuk mengambil detail resep tertentu berdasarkan ID
//    fun fetchRecipeDetails(recipeId: String) {
//        viewModelScope.launch {
//            _isLoading.value = true
//            _errorMessage.value = null
//            try {
//                val response = apiService.getRecipeDetails(recipeId)
//                _recipeDetails.value = response
//            } catch (e: Exception) {
//                _errorMessage.value = "Error fetching recipe details"
//            } finally {
//                _isLoading.value = false
//            }
//        }
//    }
//
//    // Fungsi untuk mencari resep berdasarkan kata kunci
//    fun searchRecipes(query: String) {
//        viewModelScope.launch {
//            _isLoading.value = true
//            _errorMessage.value = null
//            try {
//                val response = apiService.searchRecipes(query)
//                _searchResults.value = response.results // Asumsi response ada di "results"
//            } catch (e: Exception) {
//                _errorMessage.value = "Error searching recipes"
//            } finally {
//                _isLoading.value = false
//            }
//        }
//    }
}
