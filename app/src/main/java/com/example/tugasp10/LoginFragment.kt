package com.example.tugasp10

import HomeActivity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class LoginFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ambil referensi EditText untuk username dan password
        val usernameInput = view.findViewById<EditText>(R.id.username_input)
        val passwordInput = view.findViewById<EditText>(R.id.password_input)

        // Validasi dan login button
        val loginButton = view.findViewById<View>(R.id.login_button)
        loginButton.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            // Validasi username dan password
            if (validasiLogin(username, password)) {
                // Simpan username di SharedPreferences
                val sharedPreferences = activity?.getSharedPreferences("UserPrefs", AppCompatActivity.MODE_PRIVATE)
                val editor = sharedPreferences?.edit()
                editor?.putString("username", username)
                editor?.apply()

                // Lanjutkan ke HomeActivity
                val intent = Intent(activity, HomeActivity::class.java)
                startActivity(intent)
                activity?.finish()
            } else {
                // Jika login gagal, tampilkan toast
                activity?.let {
                    Toast.makeText(it, "Invalid username or password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    // Fungsi validasi login
    private fun validasiLogin(username: String, password: String): Boolean {
        // Gantilah logika ini dengan validasi yang sesuai (misal, mengecek username dan password di database atau API)
        return username == "admin" && password == "1234"
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
