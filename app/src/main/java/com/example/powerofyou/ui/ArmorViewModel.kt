package com.example.powerofyou.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.powerofyou.data.model.FinalArmor
import com.example.powerofyou.data.repository.ArmorRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ArmorViewModel @Inject constructor(val repo: ArmorRepo) : ViewModel() {

    val armorList: MutableLiveData<ArrayList<FinalArmor>> = MutableLiveData()
    val filteredList: MutableLiveData<ArrayList<FinalArmor>> = MutableLiveData()

    fun getArmorList() = viewModelScope.launch {
        armorList.value = repo.getArmors()
    }

    fun getFilteredArmor(name: String) = viewModelScope.launch {
        filteredList.value = repo.getFilteredArmors(name)
    }
}