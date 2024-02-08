package com.bebetta.bebettaapp.views

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bebetta.bebettaapp.R
import com.bebetta.bebettaapp.adapter.GameCategoryAdapter
import com.bebetta.bebettaapp.adapter.LiveAdapter
import com.bebetta.bebettaapp.adapter.RapidFireAdapter
import com.bebetta.bebettaapp.adapter.ScoreAdapter
import com.bebetta.bebettaapp.adapter.TickerAdapter
import com.bebetta.bebettaapp.databinding.FragmentDashboardBinding
import com.bebetta.bebettaapp.databinding.RewardBottomsheetBinding
import com.bebetta.bebettaapp.model.CategoryData
import com.bebetta.bebettaapp.model.ScoreData
import com.google.android.material.bottomsheet.BottomSheetDialog

class DashboardFragment : Fragment() {
    private lateinit var _binding: FragmentDashboardBinding
    private val binding get() = _binding
    private lateinit var _bottomSheetBinding: RewardBottomsheetBinding
    private val bottomSheetBinding get() = _bottomSheetBinding
    private lateinit var bottomSheetDialog: BottomSheetDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDashboardBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomSheetDialog = BottomSheetDialog(requireContext())

        gameCategoryList()
        tickerList()
        scoreList()
        rapidFireList()
        liveMatchList()

        /**
         * Click listener of reward bottom sheet
         */
        binding.rewardBtn.setOnClickListener {
            rewardBottomSheet()
        }

    }

    /**
     * Function to category list
     */
    private fun gameCategoryList() {
        val data = ArrayList<CategoryData>()
        data.also {
            it.add(CategoryData(R.drawable.ic_football, "Football"))
            it.add(CategoryData(R.drawable.ic_cricket, "Cricket"))
        }
        binding.gameCategoryRecyclerview.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val adapter = GameCategoryAdapter(requireContext(), data)
        binding.gameCategoryRecyclerview.adapter = adapter

    }

    /**
     * Function to score list
     */
    private fun scoreList() {
        val data = ArrayList<ScoreData>()
        data.also {
            it.add(
                ScoreData(
                    R.drawable.img_1,
                    R.drawable.alt_madrid,
                    "India",
                    "Alt Madrid",
                    "67 min"
                )
            )
            it.add(
                ScoreData(
                    R.drawable.leads_utd,
                    R.drawable.liverpool,
                    "Leads Utd.",
                    "Liverpool",
                    "54 min"
                )
            )

        }
        binding.scoreRecyclerview.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val adapter = ScoreAdapter(requireContext(), data)
        binding.scoreRecyclerview.adapter = adapter

    }

    /**
     * Function to happening tickr list
     */
    private fun tickerList() {
        val data = ArrayList<CategoryData>()
        data.also {
            it.add(CategoryData(R.drawable.img_1, "USAB"))
            it.add(CategoryData(R.drawable.dal, "DAL"))
            it.add(CategoryData(R.drawable.img_nacaf, "NCAAF"))
            it.add(CategoryData(R.drawable.madrid, "Madrid"))
            it.add(CategoryData(R.drawable.img_phi, "PHI"))
        }
        binding.tickerRecyclerview.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val adapter = TickerAdapter(requireContext(), data)
        binding.tickerRecyclerview.adapter = adapter

    }

    /**
     * Function to rapid fire list
     */
    private fun rapidFireList() {
        val data = ArrayList<String>()
        for (item in 1..1) {
            data.add("")
        }
        binding.rapidRecyclerview.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val adapter = RapidFireAdapter(requireContext(), data)
        binding.rapidRecyclerview.adapter = adapter

        /**
         * StackLayout dependency not working so unable to fix it,  But if I get some time I can fix it
         */
//      val layoutManager = StackLayoutManager(StackLayoutManager.ScrollOrientation.LEFT_TO_RIGHT)
//      layoutManager.setPagerMode(true)
//      layoutManager.setPagerFlingVelocity(3000)
//      binding.rapidRecyclerview.layoutManager = layoutManager


    }
    /**
     * Function to live matches list
     */
    private fun liveMatchList() {
        val data = ArrayList<CategoryData>()
        data.also {
            it.add(CategoryData(R.drawable.img_match_preview, "02:01"))
            it.add(CategoryData(R.drawable.img_match_thumbnail, "02:30"))
            it.add(CategoryData(R.drawable.img_thumbnail, "05:05"))
        }
        binding.matchRecyclerview.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val adapter = LiveAdapter(requireContext(), data)
        binding.matchRecyclerview.adapter = adapter

    }
    /**
     * Function to bottom sheet
     */
    private fun rewardBottomSheet() {
        _bottomSheetBinding = RewardBottomsheetBinding.inflate(layoutInflater, null, false)
        bottomSheetDialog.setCancelable(true)
        bottomSheetDialog.setContentView(_bottomSheetBinding.root)
        bottomSheetDialog.show()
        bottomSheetDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

}