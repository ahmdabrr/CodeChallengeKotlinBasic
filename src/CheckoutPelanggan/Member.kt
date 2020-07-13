package CheckoutPelanggan

class Member (val namaMember : String) : Pelanggan() {
    val arrayNama = ArrayList<String>()
    val arrayHarga = ArrayList<Int>()
    val arrayJumlah = ArrayList<Int>()

    companion object {
        const val MINIMALPEMBELIAN = 50000
        const val DISKON = 0.095
    }

    protected fun Int.idr():String {
        return ("Rp. $this,00")
    }

    public override fun inputPembelianBarang() {
        do{
            println("""
                -------------------------------------
                Checkout Pelanggan Member $namaMember
                -------------------------------------
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
        return totalBelanja* NonMember.DISKON
    }
    fun hitungDiskon (totalBelanja: Double): Double {
        return (totalBelanja*0) * NonMember.DISKON
    }

    override fun hitungTotalBelanja() {
        println("""
             -------------------------------------
              Checkout Pelanggan Member $namaMember
             -------------------------------------
        """.trimIndent())

        var totalBelanja = 0

        var i = 0
        while (i < arrayNama.size ) {
            val totalHargaBarang:Int = arrayJumlah[i]*arrayHarga[i]
            totalBelanja = totalHargaBarang+totalBelanja
            println("${arrayNama[i]} X ${arrayJumlah[i]} : ${totalHargaBarang.idr()}")
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
                Selamat ! Karena total belanjaan $namaMember
                lebih besar dari Rp. 50000, maka mendapatkan
                potongan sebesar 9.5%
                
                $namaMember cukup membayar Rp. ${totalBelanja.idr()}
            """.trimIndent())
        }
            pembayaranBarang(totalBelanja)
    }

    override fun pembayaranBarang(totalBelanja: Int) {
        print("""
            -------------------------------------
            Checkout pelanggan Member $namaMember
            -------------------------------------
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