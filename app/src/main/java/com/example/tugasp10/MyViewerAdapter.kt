import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tugasp10.LoginFragment
import com.example.tugasp10.MainActivity
import com.example.tugasp10.RegisterFragment

class MyViewerAdapter(fragment: MainActivity) : FragmentStateAdapter(fragment){

    // Menghitung jumlah tab (fragment) yang akan ditampilkan
    override fun getItemCount(): Int {
        return 2
    }

    // Mengembalikan fragment berdasarkan posisi tab
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> RegisterFragment() // Tab pertama (Register)
            1 -> LoginFragment() // Tab kedua (Login)
            else -> throw IllegalStateException("Invalid position $position")
        }
    }
}
