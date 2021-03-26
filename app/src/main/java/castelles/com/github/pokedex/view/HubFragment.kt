package castelles.com.github.pokedex.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import castelles.com.github.pokedex.R
import castelles.com.github.pokedex.data.service.repository.CharacterRepository
import castelles.com.github.pokedex.databinding.FragmentHubBinding
import kotlinx.android.synthetic.main.fragment_hub.*
import org.koin.android.ext.android.inject

class HubFragment : Fragment() {

    private val characterRepository: CharacterRepository by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentHubBinding
        .inflate(inflater)
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        back.setOnClickListener {
            findNavController().navigate(R.id.action_hubFragment_self2)
        }

    }
}