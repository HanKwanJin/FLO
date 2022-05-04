package com.example.flo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flo.databinding.ItemSongBinding

class SaveRVAdapter(private val albumList: ArrayList<Album>): RecyclerView.Adapter<SaveRVAdapter.ViewHolder>() {
    interface MyItemClickListener{
        fun onRemoveAlbum(position: Int)
    }
    private lateinit var myItemClickListener: MyItemClickListener
    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        myItemClickListener = itemClickListener
    }
    fun removeItem(position: Int){
        albumList.removeAt(position)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaveRVAdapter.ViewHolder {
        val binding: ItemSongBinding = ItemSongBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SaveRVAdapter.ViewHolder, position: Int) {
        holder.bind(albumList[position])
        holder.binding.songMoreIb.setOnClickListener {
            myItemClickListener.onRemoveAlbum(position)
        }
    }

    override fun getItemCount(): Int = albumList.size
    inner class ViewHolder(val binding: ItemSongBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(album: Album){
            binding.songTitleTv.text = album.title
            binding.songSingerTv.text = album.singer
            binding.songCoverImg.setImageResource(album.coverImg!!)
        }
    }
}