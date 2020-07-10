class MenuCheckout {
    fun checkoutPelanggan () {
        println("""
            ------------------------
            Chekout Pelanggan
            ------------------------
            1. Pelanggan Member
            2. Pelanggan Non-Member
            ------------------------
            """.trimIndent())
        val pilihanInput = readLine()

        when (pilihanInput) {
            "1" -> menuMember()
            "2" -> menuNonMember()
        }
    }

    fun pelangganMember () {
        println("""
            -----------------------------------
            Chekout Pelanggan Member
            -----------------------------------
            """.trimIndent())
        print("Input nama member : ")
        println("-------------------------------")
        val memberInput = readLine()

        if (memberInput == "") {
            MenuCheckout().menuMember()
        }
    }

    private fun menuMember () {
        println("""
            -----------------------------------
            Chekout Pelanggan Member 
            -----------------------------------
            """.trimIndent())
        print("Input nama barang : ")
        val barangInput = readLine()!!
        print("Input harga satuan barang : ")
        val hargaBarang = readLine()!!
        print("Input jumlah barang : ")
        val jumlahBarang = readLine()!!
        println("------------------------------")
        println("Input Barang Lagi ? (Ya/Tidak)")

        val nextBarang: String = readLine()!!
        if (nextBarang == "Yes"){
            return menuMember()
        }else {
            println("""
            -----------------------------------
            Chekout Pelanggan Member 
            -----------------------------------
            """.trimIndent())

        }
    }

    private fun menuNonMember () {
        println("""
            -----------------------------------
            Chekout Pelanggan Non Member 
            -----------------------------------
            """.trimIndent())
        print("Input nama barang : ")
        val barangInput2 = readLine()!!
        print("Input harga satuan barang : ")
        val hargaBarang2 = readLine()!!
        print("Input jumlah barang : ")
        val jumlahBarang2 = readLine()!!
        println("------------------------------")
        println("Input Barang Lagi ? (Ya/Tidak)")

        val nextBarang: String = readLine()!!
        if (nextBarang == "Yes"){
            return menuMember()
        }else {
            println("""
            -----------------------------------
            Chekout Pelanggan Non Member 
            -----------------------------------
            """.trimIndent())

        }
    }
}