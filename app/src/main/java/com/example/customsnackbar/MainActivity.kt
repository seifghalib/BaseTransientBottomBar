package com.example.customsnackbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.customsnackbar.chef.ChefSnackbar
import com.example.customsnackbar.databinding.ActivityMainBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_INDEFINITE

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonChef.setOnClickListener {
            val chefSnackbar = ChefSnackbar.make(it)
            chefSnackbar.addCallback(snackBar)
                .duration = LENGTH_INDEFINITE

            chefSnackbar.show()
        }
    }

   private val snackBar = object : BaseTransientBottomBar.BaseCallback<ChefSnackbar>() {
       override fun onDismissed(transientBottomBar: ChefSnackbar?, event: Int) {

           binding.textViewChef.text = event.toString()
       }

       override fun onShown(transientBottomBar: ChefSnackbar?) {

           transientBottomBar?.view?.setOnClickListener {
               transientBottomBar.dismiss()
           }

           binding.textViewChef.text = "NIMEIONAAA"
       }
   }
}
