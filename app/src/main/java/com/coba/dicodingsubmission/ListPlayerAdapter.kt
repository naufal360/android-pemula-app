package com.coba.dicodingsubmission

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListPlayerAdapter(val listPlayer: ArrayList<Player>) : RecyclerView.Adapter<ListPlayerAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_card_player, viewGroup,false )
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListPlayerAdapter.ListViewHolder, position: Int) {
        val (name, overall, photo, overview, identity) = listPlayer[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvOverall.text = overall

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, detail_player::class.java)
            moveDetail.putExtra(detail_player.EXTRA_OVERALL, overall)
            moveDetail.putExtra(detail_player.EXTRA_NAME, name)
            moveDetail.putExtra(detail_player.EXTRA_PHOTO, photo)
            moveDetail.putExtra(detail_player.EXTRA_IDENTITY, identity)
            moveDetail.putExtra(detail_player.EXTRA_OVERVIEW, overview)
            mContext.startActivity(moveDetail)
        }
    }

    override fun getItemCount(): Int {
        return listPlayer.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvOverall: TextView = itemView.findViewById(R.id.tv_item_overall)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }


}