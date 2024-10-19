package com.example.tugasp10
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class HomeActivity : AppCompatActivity() {

    private lateinit var welcomeTextView: TextView
    private lateinit var avatarImageView: ImageView
    private lateinit var howTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Inisialisasi Views
        welcomeTextView = findViewById(R.id.welcome)
        avatarImageView = findViewById(R.id.avatar)
        howTextView = findViewById(R.id.how)

        // Ambil data username dari SharedPreferences
        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val username = sharedPreferences.getString("username", "Guest")

        // Menampilkan username di dalam TextView "Welcome"
        welcomeTextView.text = if (!username.isNullOrEmpty()) {
            "Welcome Back, $username!"
        } else {
            "Welcome!"
        }

        // (Opsional) Ambil avatar atau data lain dari SharedPreferences atau intent jika perlu
        // Contoh, jika avatar diambil dari SharedPreferences
        // val avatarResId = sharedPreferences.getInt("avatar_id", R.drawable.default_avatar)
        // avatarImageView.setImageResource(avatarResId)
    }
}
