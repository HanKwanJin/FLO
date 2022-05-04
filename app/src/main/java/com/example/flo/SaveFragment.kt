package com.example.flo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flo.databinding.FragmentSaveBinding

class SaveFragment:Fragment() {
    lateinit var binding: FragmentSaveBinding
    private var albumDatas = ArrayList<Album>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSaveBinding.inflate(inflater, container, false)
        albumDatas.apply {
            add(Album("Butter", "방탄소년단 (BTS)", R.drawable.img_album_exp))
            add(Album("Lilac", "아이유 (IU)", R.drawable.img_album_exp2))
            add(Album("Savage", "에스파 (AESPA)", R.drawable.img_album_exp3))
            add(Album("Invu", "태연", R.drawable.img_album_exp4))
        }
        val saveRVAdapter = SaveRVAdapter(albumDatas)
        binding.saveRv.adapter = saveRVAdapter
        binding.saveRv.layoutManager = LinearLayoutManager(context)
        saveRVAdapter.setMyItemClickListener(object : SaveRVAdapter.MyItemClickListener{
            override fun onRemoveAlbum(position: Int) {
                saveRVAdapter.removeItem(position)
            }
        })
        return binding.root
    }
}