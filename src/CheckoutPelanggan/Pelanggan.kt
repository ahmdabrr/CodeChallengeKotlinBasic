package CheckoutPelanggan

abstract class Pelanggan {
    protected abstract fun inputPembelianBarang()
    protected abstract fun hitungTotalBelanja()
    protected abstract fun pembayaranBarang(totalBelanja: Int)
}