package com.example.lmwncryptoappfinal

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.load

import com.example.lmwncryptoappfinal.models.Coin
import kotlin.reflect.full.memberProperties

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> () {

    var items = ArrayList<Coin> ()
    fun setUpdatedData(items : ArrayList<Coin>){
        this.items = items
        notifyDataSetChanged()
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imageIcon = view.findViewById<ImageView>(R.id.coin_icon)
        val symbol = view.findViewById<TextView>(R.id.coin_symbol)
        val name = view.findViewById<TextView>(R.id.coin_div)
        val rank = view.findViewById<TextView>(R.id.coin_rank)
        val url = view.findViewById<Button>(R.id.accessUrl)


        fun bind(data : Coin) {
            symbol.text = data.symbol
            name.text = data.name
            rank.text = data.rank.toString()

            //Use coil to load icon

            imageIcon.load(data.iconUrl) {
                placeholder(R.drawable.ic_launcher_background)
            }
            
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.coinsdet,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items.get(position))
    }

}