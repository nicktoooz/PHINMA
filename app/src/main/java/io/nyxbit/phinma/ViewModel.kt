package io.nyxbit.phinma

import androidx.lifecycle.ViewModel

class ViewModel : ViewModel(){
    var initiator : String = ""
    var school : String = ""
    var fullName : String = ""
    var course : String = ""
    var year : String = ""
    var address: String = ""
    var mobileNumber : String = ""

    fun clear(){
        school = ""
        fullName = ""
        course = ""
        year = ""
        address = ""
        mobileNumber = ""
    }
}