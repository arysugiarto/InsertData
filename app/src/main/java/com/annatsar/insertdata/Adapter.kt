package com.annatsar.insertdata

import android.content.Context
import android.content.LocusId
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.AbsListView
import android.widget.ArrayAdapter
import android.widget.TextView
import java.text.FieldPosition

class Adapter(val mCtx: Context, val layoutResId: Int, val list: List<Users>)
    : ArrayAdapter<Users>(mCtx,layoutResId,list){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup):
            View{
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view:View = layoutInflater.inflate(layoutResId,null)

        val textNIM = view.findViewById<TextView>(R.id.textNim)
        val textNama= view.findViewById<TextView>(R.id.textNama)
        val textJurusan = view.findViewById<TextView>(R.id.textJurusan)
        val textUniversitas = view.findViewById<TextView>(R.id.textUniversitas)

        val user = list[position]

        textNIM.text = user.NIM
        textNama.text = user.nama
        textJurusan.text = user.jurusan
        textUniversitas.text = user.universitas

        return view
    }
}