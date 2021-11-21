package com.websarva.wings.android.kaigonote.debug

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.websarva.wings.android.kaigonote.databinding.FragmentDebugTabBinding

class DebugTabFragment : Fragment() {

    companion object {
        const val TITLE = "title"
    }

    var binding: FragmentDebugTabBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDebugTabBinding.inflate(inflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = arguments?.getString(TITLE) ?: "title"
        binding!!.title.text = title
    }
}
