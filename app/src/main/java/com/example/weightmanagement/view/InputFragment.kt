package com.example.weightmanagement.view

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_input.*
import com.example.weightmanagement.R
import com.example.weightmanagement.model.Data
import com.example.weightmanagement.viewmodel.InputViewModel


class InputFragment :Fragment() {

    private val viewModel: InputViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ok.setOnClickListener {
            register()
        }
    }

    private fun toastMake(message: String, x: Int, y: Int) {
        val toast = Toast.makeText(context, message, Toast.LENGTH_LONG)
        // 位置調整
        toast.setGravity(Gravity.CENTER, x, y)
        toast.show()
    }

    private fun makeString(view: EditText) = view.text.toString()

    private fun makeInt(view: EditText): Int =
        if (makeString(view) == "") 0 else makeString(view).toInt()

    private fun register() {
        if (makeInt(weight_edit_text) != 0) {
            // エディットテキストのテキストを取得
            val data = Data(
                makeInt(date_edit_text),
                makeInt(weight_edit_text),
                makeInt(body_fat_percentage_edit_text),
                makeInt(bmi_edit_text)
            )

            toastMake(getString(R.string.message_finish), 0, 500)
            viewModel.setWeights(data)

        } else {
            toastMake(getString(R.string.message_hint), 0, 500)
        }
        findNavController().navigate(R.id.pagerBaseFragment)
    }
}
