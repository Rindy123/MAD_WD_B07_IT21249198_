package com.example.myapplication

class Product(toString: String, toString1: String, toString2: String, toString3: String, toString4: String, toString5: String, toString6: String, toString7: String, toString8: String, toString9: String, toString10: String, toString11: String) {
    private var OrganicalF1: String? = null
    private var OrganicalF2: String? = null
    private var OrganicalF3: String? = null
    private var PapSeed: String? = null
    private var PomeSeed: String? = null
    private var Riceseed: String? = null
    private var CarrotSeed: String? = null
    private var EggPSeed: String? = null
    private var TotalPrice: String? = null
    private var Photo: String? = null
    private var Status: String? = null
    private var Customer: String? = null
    fun Product(organicalf1: String, organicalf2: String, organicalf3: String, papseed: String, pomeseed: String, riceseed: String, carrotseed: String, eggpseed: String, totalprice: String, photo: String, status: String, customer: String) {
        OrganicalF1 = organicalf1
        OrganicalF2 = organicalf2
        OrganicalF3 = organicalf3
        PapSeed= papseed
        PomeSeed = pomeseed
        Riceseed = riceseed
        CarrotSeed = carrotseed
        EggPSeed= eggpseed
        TotalPrice = totalprice
        Photo = photo
        Status = status
        Customer= customer
    }

    fun Product() {}


    fun getOrganicalF1(): String? {
        return OrganicalF1
    }
    fun setOrganicalF1(organicalf1: String) {
        OrganicalF1 = organicalf1
    }
    fun getOrganicalF2(): String? {
        return OrganicalF2
    }
    fun setOrganicalF2(organicalf2: String) {
        OrganicalF2 = organicalf2
    }
    fun getOrganicalF3(): String? {
        return OrganicalF3
    }
    fun setOrganicalF3(organicalf3: String) {
        OrganicalF3 = organicalf3
    }
    fun getPapSeed(): String? {
        return PapSeed
    }
    fun getPomeSeed(): String? {
        return PomeSeed
    }
    fun getRiceseed(): String? {
        return Riceseed
    }
    fun getCarrotSeed(): String? {
        return CarrotSeed
    }
    fun getEggPSeed(): String? {
        return EggPSeed
    }
    fun getTotalPrice(): String? {
        return TotalPrice
    }
    fun getPhoto(): String? {
        return Photo
    }
    fun getStatus(): String? {
        return Status
    }
    fun getCustomer(): String? {
        return Customer
    }
}