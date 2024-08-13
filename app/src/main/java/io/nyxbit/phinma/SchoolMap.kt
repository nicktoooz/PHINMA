package io.nyxbit.phinma

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import io.nyxbit.phinma.databinding.FragmentSchoolMapBinding

class SchoolMap : Fragment() {

    private lateinit var binding: FragmentSchoolMapBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSchoolMapBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(requireActivity())[ViewModel::class.java]

        // Initialize WebView
        val webView: WebView = binding.webView

        // Configure WebView settings
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true // Enable JavaScript if needed

        // Set a WebViewClient to handle page navigation within the WebView
        webView.webViewClient = WebViewClient()

        // Load a URL or local HTML file
        webView.loadUrl(viewModel.school.map)

        return binding.root
    }
}
