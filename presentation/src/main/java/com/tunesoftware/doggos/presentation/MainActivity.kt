package com.tunesoftware.doggos.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import com.tunesoftware.doggos.domain.Breed
import com.tunesoftware.doggos.presentation.MainViewModel.*
import com.tunesoftware.doggos.presentation.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()
    private val adapter by lazy { BreedListAdapter { breed, view ->
        viewModel.breedClicked(breed, view)
    } }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.state.observe(this) { state ->
            when (state) {
                is MainState.BreedsList -> displayBreeds(state.breeds)
                is MainState.NavigateToDetail -> {
                    val opts = ActivityOptionsCompat.makeSceneTransitionAnimation(this, state.view, ViewCompat.getTransitionName(state.view) ?: "")
                    startActivity(DetailActivity.getIntent(this, state.breed.name, state.breed.imageUrl), opts.toBundle())
                }
            }
        }

        binding.rcyBreeds.adapter = adapter
    }

    private fun displayBreeds(breeds: List<Breed>) {
        adapter.submitList(breeds)
    }
}