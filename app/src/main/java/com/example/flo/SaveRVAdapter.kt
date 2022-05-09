package com.example.flo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flo.databinding.ItemSongBinding

class SaveRVAdapter(private val albumList: ArrayList<Song>): RecyclerView.Adapter<SaveRVAdapter.ViewHolder>() {
    interface MyItemClickListener{
        fun onRemoveAlbum(position: Int)
    }
    private lateinit var myItemClickListener: MyItemClickListener
    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        myItemClickListener = itemClickListener
    }
    fun addSongs(songs: ArrayList<Song>){
        this.albumList.clear()
        this.albumList.addAll(songs)
        notifyDataSetChanged()
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
        fun bind(song: Song){
            binding.songTitleTv.text = song.title
            binding.songSingerTv.text = song.singer
            binding.songCoverImg.setImageResource(song.coverImg!!)
        }
    }
}