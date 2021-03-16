package com.tunesoftware.doggos.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.tunesoftware.doggos.domain.BreedDetail
import com.tunesoftware.doggos.presentation.databinding.ActivityDetailBinding
import com.tunesoftware.doggos.presentation.DetailViewModel.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    private val viewModel by viewModel<DetailViewModel>()
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel.state.observe(this) { state ->
            when (state) {
                is DetailState.BreedDetails -> displayDetails(state.breedDetail)
                is DetailState.BreedNotFound -> Toast.makeText(
                    this,
                    "breed not found",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        val breedName = intent?.getStringExtra(EXTRA_BREED_NAME)
        title = breedName
        binding.txtBreedName.text = breedName
        binding.imgBreedDetail.transitionName = breedName
        binding.imgBreedDetail.load(intent?.getStringExtra(EXTRA_IMAGE_URL))

        viewModel.getDetails(breedName ?: "")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                supportFinishAfterTransition()
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun displayDetails(breedDetail: BreedDetail) {
        binding.txtTemperament.text = breedDetail.temperament
    }

    companion object {
        private const val EXTRA_BREED_NAME = "breed_name"
        private const val EXTRA_IMAGE_URL = "image_url"

        fun getIntent(context: Context, breedName: String, imageUrl: String) =
            Intent(context, DetailActivity::class.java).apply {
                putExtra(EXTRA_BREED_NAME, breedName)
                putExtra(EXTRA_IMAGE_URL, imageUrl)
            }
    }
}
