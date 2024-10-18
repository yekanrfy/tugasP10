import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.tugasp10.LoginFragment
import com.example.tugasp10.RegisterFragment

class ViewPager2(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    // Menghitung jumlah tab (fragment) yang akan ditampilkan
    override fun getCount(): Int {
        return 2 // Ada 2 tab: Register dan Login
    }

    // Mengembalikan fragment berdasarkan posisi tab
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> RegisterFragment() // Tab pertama (Register)
            1 -> LoginFragment() // Tab kedua (Login)
            else -> throw IllegalStateException("Invalid position $position")
        }
    }

    // Mengatur judul dari masing-masing tab
    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Register" // Judul untuk tab pertama
            1 -> "Login" // Judul untuk tab kedua
            else -> throw IllegalStateException("Invalid position $position")
        }
    }
}
