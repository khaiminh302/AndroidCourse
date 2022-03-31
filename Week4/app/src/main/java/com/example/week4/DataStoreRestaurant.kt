package com.example.week4

import com.example.week4.model.Restaurant

object DataStoreRestaurant {
    fun getDataSet(): List<Restaurant>{
        return listOf(
            Restaurant(33760, "Du Miên Garden Cafe - Phan Văn Trị", "7 Phan Văn Trị, P. 10", R.drawable.dumiengarden),
            Restaurant(978, "Country House Cafe", "18C Phan Văn Trị, P. 10", R.drawable.countryhouse),
            Restaurant(82801, "Hẻm Spaghetti - Nguyễn Oanh", "212/22 Nguyễn Oanh, P. 17", R.drawable.hemspaghetti),
            Restaurant(149154, "Lava Coffee - Quang Trung", "61 Quang Trung, P. 10", R.drawable.lavacoffee),
            Restaurant(194867,"Mì Cay Naga - 224 Phạm Văn Đồng", "224 Phạm Văn Đồng, P.1 ", R.drawable.micaynaga),
            Restaurant(25656, "City House Cafe - Sân Vườn Lãng Mạn", "21 Huỳnh Khương An, P. 5", R.drawable.cityhousecafe),
            Restaurant(66844, "Nhi Nhi Quán - Đặc Sản Phan Rang", "125/48 Lê Đức Thọ, P. 17", R.drawable.nhinhiquan),
            Restaurant(33645, "Yuri Yuri - Ẩm Thực Hàn Quốc","358 Nguyễn Văn Nghi, P. 7", R.drawable.yuriyuri ),
            Restaurant(252442, "Trà Sữa Gong Cha - 貢茶 - Phan Văn Trị", "595 Phan Văn Trị, P. 5", R.drawable.gongcha),
            Restaurant(12513, "Oasis Cafe", "26/14 Phạm Văn Đồng, P. 3", R.drawable.oasiscafe),
            Restaurant(199622, "Buzza Pizza - Emart Gò Vấp", "Tầng Trệt Emart Gò Vấp - 366 Phan Văn Trị, P. 5", R.drawable.buzzapizza),
            Restaurant(651063, "Dallas Cakes & Coffee - Quang Trung", "6 Quang Trung, P. 10", R.drawable.dallascakecafe),
            Restaurant(60915, "Hot & Cold - Trà Sữa & Xiên Que - Quang Trung", "804 Quang Trung", R.drawable.hotandcold),
            Restaurant(112585, "Papaxốt - Quang Trung", "458 Quang Trung", R.drawable.papaxot),
            Restaurant(91979, "SaiGon Chic Cafe", "82 Đường Số 27, P. 6", R.drawable.saigonchiccafe),
            Restaurant(28883,"Pizza Hut - Quang Trung", "283 Quang Trung", R.drawable.pizzahut),
            Restaurant(129725, "Bánh Mì Chảo & Món Ngon Hoa Việt - Quán Cô 3 Hậu", "36 Đường Số 18,P. 8", R.drawable.banhmichao ),
            Restaurant(46668, "Kichi Kichi Lẩu Băng Chuyền - Quang Trung", "1 Quang Trung", R.drawable.kichikichi),
            Restaurant(158187, "The Coffee House - Quang Trung", "293 Quang Trung", R.drawable.coffehouse),
            Restaurant(30102, "Cánh Đồng Quán - Lẩu Nướng Tại Bàn - Dương Quảng Hàm", "310/14 Dương Quảng Hàm, P. 5", R.drawable.canhdongquan)
        )

    }
}