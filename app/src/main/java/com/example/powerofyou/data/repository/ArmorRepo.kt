package com.example.powerofyou.data.repository

import com.example.powerofyou.R
import com.example.powerofyou.data.model.AmorResponseItem
import com.example.powerofyou.data.model.ArmorResponse
import com.example.powerofyou.data.model.FinalArmor
import com.example.powerofyou.data.network.ArmorApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ArmorRepo @Inject constructor(val api: ArmorApi) {
    val finalList = ArrayList<FinalArmor>()

    suspend fun getArmors(): ArrayList<FinalArmor> {

        api.getArmor().map {

            var type = 0
            when (it.type) {
                "chest" -> {
                    type = R.drawable.ic_chest

                }
                "gloves" -> {
                    type = R.drawable.ic_gloves
                }
                "head" -> {
                    type = R.drawable.ic_head
                }
                "legs" -> {
                    type = R.drawable.ic_legs
                }
                "waist" -> {
                    type = R.drawable.ic_waist
                }
            }
            finalList.add(
                FinalArmor(
                    it.name,
                    it.rank.toString(),
                    it.defense?.base.toString(),
                    it.slots?.size.toString(),
                    type
                )
            )
        }

        return finalList
    }

    fun getFilteredArmors(name: String): ArrayList<FinalArmor> {
        return finalList.filter {
            it.name!!.lowercase().contains(name.lowercase())
        } as ArrayList<FinalArmor>
    }


}