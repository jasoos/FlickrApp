package com.android.flickr_app.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "photos")
class Photo(
  /*  @PrimaryKey*/
    var id: String = "",
    /*@ColumnInfo(name = "secret")*/ var secret: String = "",
   /* @ColumnInfo(name = "server")*/ var server: String = "",
    /*@ColumnInfo(name = "farm")*/ var farm: Int = 0,
    /*@ColumnInfo(name = "title")*/ var title: String? = null,
   /* @ColumnInfo(name = "url_l")*/ var url_l: String? = null,
    /*@ColumnInfo(name = "url_o")*/ var url_o: String? = null,
   /* @ColumnInfo(name = "url_c")*/ var url_c: String? = null,
   /* @ColumnInfo(name = "url_z")*/ var url_z: String? = null,
    /*@ColumnInfo(name = "url_n")*/ var url_n: String? = null,
   /* @ColumnInfo(name = "url_m")*/ var url_m: String? = "",
    /*@ColumnInfo(name = "url_q")*/ var url_q: String? = null,
   /* @ColumnInfo(name = "url_s")*/ var url_s: String? = null,
    /*@ColumnInfo(name = "url_t")*/ var url_t: String? = null,
    /*@ColumnInfo(name = "url_sq")*/ var url_sq: String? = null
)