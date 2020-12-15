package com.monolith.uedapagesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    //ビューグループに追加したレイアウトの個数をカウントするための変数
    var count=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //右下追加ボタンリスナ
        findViewById<FloatingActionButton>(R.id.fab_add).setOnClickListener{
            layout_add()
        }
    }

    //レイアウトを追加する関数
    fun layout_add(){

        //スクロールビューのidを取得してビューグループ（一つのまとまりとして扱える形）にする
        val SV: ViewGroup = findViewById<View>(R.id.sv_vertical) as ViewGroup

        //削除する場合は下のコメントアウトを外す(リスト更新時等）
        //SV.removeAllViews()

        //スクロールビューのビューグループにレイアウトデータを読み込み追加する
        getLayoutInflater().inflate(R.layout.add_layout_xml_data,SV)

        //今回追加したレイアウトのデータを取得
        val layout:ConstraintLayout=SV.getChildAt(count)as ConstraintLayout

        //レイアウトに番号のタグをつけることで後で扱いやすくなる
        layout.setTag(count)

        //add_layout_xml_data.xmlのレイアウト内に3番目（0スタートのため2）に配置したデータを取得する
        ((layout.getChildAt(0)as TextView).setText("追加後にテキストを編集しています"))

        //レイアウトにリスナーを設定
        //it.getTag().toString()で先ほど設定したタグ情報を取得できる
        //※使用用途を考えた上でボタンではなくレイアウトにリスナーを敢えて設定してます
        layout.setOnClickListener{
            ToastTsukuruyo(it.getTag().toString().toInt())
        }

        count+=1

    }

    //ボタンが押された場合は何番目が押されたかトーストするための関数
    fun ToastTsukuruyo(n : Int){
        Toast.makeText(applicationContext, n.toString()+"番目に追加したレイアウト", Toast.LENGTH_SHORT).show()
    }
}