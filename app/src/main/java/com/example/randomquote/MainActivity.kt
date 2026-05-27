package com.example.randomquote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.randomquote.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val quotes = listOf(
        Quote(
            text = "The only way to do great work is to love what you do.",
            author = "Steve Jobs"
        ),
        Quote(
            text = "Life is what happens when you’re busy making other plans.",
            author = "John Lennon"
        ),
        Quote(
            text = "Do not wait to strike till the iron is hot; but make it hot by striking.",
            author = "William Butler Yeats"
        ),
        Quote(
            text = "Success is not final, failure is not fatal: it is the courage to continue that counts.",
            author = "Winston Churchill"
        ),
        Quote(
            text = "Your time is limited, so don’t waste it living someone else’s life.",
            author = "Steve Jobs"
        ),
        Quote(
            text = "The best way to predict the future is to create it.",
            author = "Peter Drucker"
        )
    )
    private var currentIndex = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.app_name)

        binding.newQuoteButton.setOnClickListener {
            showRandomQuote()
        }

        showRandomQuote()
    }

    private fun showRandomQuote() {
        var nextIndex = Random.nextInt(quotes.size)
        while (quotes.size > 1 && nextIndex == currentIndex) {
            nextIndex = Random.nextInt(quotes.size)
        }
        currentIndex = nextIndex

        val quote = quotes[currentIndex]
        binding.quoteText.text = "\"${quote.text}\""
        binding.authorText.text = "— ${quote.author}"
    }

    private data class Quote(val text: String, val author: String)
}
