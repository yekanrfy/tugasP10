package com.example.tugasp10

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ambil referensi EditText untuk username, email, phone, dan password
        val usernameInput = view.findViewById<EditText>(R.id.username_input)
        val emailInput = view.findViewById<EditText>(R.id.email_input)
        val phoneInput = view.findViewById<EditText>(R.id.phone_input)
        val passwordInput = view.findViewById<EditText>(R.id.password_input)

        // Ambil referensi Button register
        val registerButton = view.findViewById<Button>(R.id.btn_register)

        // Set onClickListener untuk tombol register
        registerButton.setOnClickListener {
            val username = usernameInput.text.toString()
            val email = emailInput.text.toString()
            val phone = phoneInput.text.toString()
            val password = passwordInput.text.toString()

            // Validasi input
            if (validateRegister(username, email, phone, password)) {
                // Simpan username di SharedPreferences atau lakukan proses pendaftaran
                val sharedPreferences = activity?.getSharedPreferences("UserPrefs", AppCompatActivity.MODE_PRIVATE)
                val editor = sharedPreferences?.edit()
                editor?.putString("username", username)
                editor?.apply()

                // Lanjutkan ke HomeActivity atau halaman selanjutnya
                val intent = Intent(activity, HomeActivity::class.java)
                startActivity(intent)
                activity?.finish()
            } else {
                // Jika registrasi gagal, tampilkan toast
                activity?.let {
                    Toast.makeText(it, "Please fill all fields correctly", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    // Fungsi validasi pendaftaran
    private fun validateRegister(username: String, email: String, phone: String, password: String): Boolean {
        // Cek jika semua input sudah diisi
        return username.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty() && password.isNotEmpty()
    }

    companion object {
        @JvmStatic
        fun newInstance() = RegisterFragment()
    }
}
