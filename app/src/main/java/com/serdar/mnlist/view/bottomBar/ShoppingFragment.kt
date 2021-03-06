package com.serdar.mnlist.view.bottomBar

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.serdar.mnlist.R
import com.serdar.mnlist.data.Shopping
import com.serdar.mnlist.databinding.FragmentShoppingBinding
import com.serdar.mnlist.viewmodel.ShoppingViewModel

class ShoppingFragment : Fragment() {
    private  val shoppingViewModel by lazy { ShoppingViewModel(requireActivity().application) }

    private lateinit var binding:FragmentShoppingBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding=FragmentShoppingBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addButton.setOnClickListener {
            insertDataToDataBase()
            findNavController().navigate(R.id.action_shoppingFragment_to_homeFragment)

        }
    }

    private fun insertDataToDataBase() {

        val productName =binding.productNames.text.toString()
        val productSize =binding.productSizes.text.toString()
        val productStore =binding.productStores.text.toString()

        val shopping=Shopping(0,productName,productSize,productStore)
        shoppingViewModel.addShoping(shopping)

        if(inputCheck(productName,productSize,productStore)){
            Toast.makeText(requireContext(),"Empty List ",Toast.LENGTH_SHORT).show()
        }
    }
    private fun inputCheck(productNames:String,prodoctSizes:String,productStores:String):Boolean{
        return !(TextUtils.isEmpty(productNames)&&TextUtils.isEmpty(prodoctSizes)&&TextUtils.isEmpty(productStores))

    }

}