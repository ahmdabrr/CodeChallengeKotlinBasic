package CheckoutPelanggan

class NonMember() : Pelanggan() {
    val arrayNama = ArrayList<String>()
    val arrayHarga = ArrayList<Int>()
    val arrayJumlah = ArrayList<Int>()

    companion object {
        const val MINIMALPEMBELIAN = 70000
        const val DISKON = 0.041
    }

    protected fun Int.idr():String {
        return ("Rp. $this,00")
    }

    public override fun inputPembelianBarang() {
        do{
            println("""
                -----------------------------
                Checkout Pelanggan Non-Member 
                -----------------------------
            """.trimIndent())

            print("Input nama barang : ")
            val namBar = readLine()!!

            print("Input harga barang : ")
            val harBar = readLine()!!.toInt()

            print("Input jumlah barang : ")
            val jumBar = readLine()!!.toInt()

            arrayNama.add (namBar)
            arrayHarga.add (harBar)
            arrayJumlah.add (jumBar)

            print("""
                ------------------------------------
                Input barang lagi ? 
                Masukkan inputan (Y/T) : 
            """.trimIndent())

            val inputan = readLine()!!.single()
        } while (inputan == 'Y')

        hitungTotalBelanja()
    }

    fun hitungDiskon (totalBelanja: Int): Double {
        return totalBelanja* DISKON
    }
    fun hitungDiskon (totalBelanja: Double): Double {
        return (totalBelanja*0) * DISKON
    }

    override fun hitungTotalBelanja() {
        println("""
                -----------------------------
                Checkout Pelanggan Non-Member 
                -----------------------------
        """.trimIndent())

        var totalBelanja = 0

        var i = 0
        while (i < arrayNama.size ) {
            val totalHargaBarang:Int = arrayJumlah[i]*arrayHarga[i]
            totalBelanja = totalHargaBarang+totalBelanja
            println("${arrayNama[i]} X ${arrayJumlah[i]} : Rp. ${totalHargaBarang.idr()}")
            i++
        }

        println("""
            -----------------------------
            Total belanja : ${totalBelanja.idr()}
            -----------------------------
        """.trimIndent())

        if (totalBelanja > MINIMALPEMBELIAN){
            val diskon = totalBelanja.toDouble() * DISKON
            totalBelanja = totalBelanja - diskon.toInt()
            println("""
                Selamat ! Karena total belanjaan lebih besar 
                dari Rp. 50000, maka mendapatkan potongan sebesar 4.1%
                
                cukup membayar Rp. ${totalBelanja.idr()}
            """.trimIndent())
        }
        pembayaranBarang(totalBelanja)
    }

    override fun pembayaranBarang(totalBelanja: Int) {
        print("""
            -----------------------------
            Checkout Pelanggan Non-Member 
            -----------------------------
            Total belanja : Rp. ${totalBelanja.idr()}
            
            Input uang customer : Rp.
        """.trimIndent())

        val uangCustomer = readLine()
        if (uangCustomer != null){
            if (uangCustomer.toInt() < totalBelanja) {
                println("Uang customer kurang")
            } else {
                val kembalian = uangCustomer.toInt() - totalBelanja
                println("""
                    ---------------------------
                    kembalian : Rp. ${kembalian.idr()}
                    ---------------------------
                    
                    - Terima kasih -
                """.trimIndent())
            }
        }
    }
}