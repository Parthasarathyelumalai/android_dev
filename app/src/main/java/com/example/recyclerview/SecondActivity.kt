package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.recyclerview.base.Validation

class SecondActivity : AppCompatActivity() {
    private lateinit var etfirstName: EditText
    private lateinit var etlastName: EditText
    private lateinit var etemailId: EditText
    private lateinit var etphoneNumber: EditText
    private lateinit var etnewPassword: EditText
    private lateinit var etconfirmPassword: EditText
    private lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        etfirstName = findViewById(R.id.et_first_name)
        etlastName = findViewById(R.id.et_last_name)
        etphoneNumber = findViewById(R.id.et_phone_number)
        etemailId = findViewById(R.id.et_email_id)
        etnewPassword = findViewById(R.id.et_password)
        etconfirmPassword = findViewById(R.id.et_confirm_password)

        /*Prepopulate the data*/
        etfirstName.setText("Vijay")
        etlastName.setText("G")
        etphoneNumber.setText("9003103329")
        etemailId.setText("Vijay@gmail.com")
        etnewPassword.setText("Vijay@1234")
        etconfirmPassword.setText("Vijay@1234")

        btn = findViewById(R.id.btn_submit)
        var validation: Validation = Validation()
        btn = findViewById(R.id.btn_submit)
        btn.setOnClickListener {
            var isValidInput: Boolean = false;
            val firstName = etfirstName.text.toString().trim()
            val lastName = etlastName.text.toString().trim()
            val phoneNumber = etphoneNumber.text.toString()
            val emailId = etemailId.text.toString()
            val newPassword = etnewPassword.text.toString()
            val confirmPassword = etconfirmPassword.text.toString()
            if (firstName.isEmpty()) {
                etfirstName.error = resources.getString(R.string.empty_message_name);
                isValidInput = true
            } else if (!validation.isValidUsername(firstName)) {
                isValidInput = true
                etfirstName.error = resources.getString(R.string.text_validation_error_first_name);
            }
            if (lastName.isEmpty()) {
                etlastName.error = resources.getString(R.string.empty_message_last_name);
                isValidInput = true
            } else if (!validation.isValidUsername(lastName)) {
                etlastName.error = resources.getString(R.string.text_validation_error_last_name);
                isValidInput = true
            }
            if (phoneNumber.isEmpty()) {
                etphoneNumber.error =
                    resources.getString(R.string.empty_message_phone_number);
                isValidInput = true
            } else if (!validation.isValidPhoneNumber(phoneNumber)) {
                etphoneNumber.error =
                    resources.getString(R.string.text_validation_error_phone_number);
                isValidInput = true
            }
            if (emailId.isEmpty()) {
                etemailId.error = resources.getString(R.string.empty_message_email);
                isValidInput = true
            } else if (!validation.isValidEmail(emailId)) {
                etemailId.error = resources.getString(R.string.text_validation_error_email);
                isValidInput = true
            }
            if (newPassword.isEmpty()) {
                etnewPassword.error = resources.getString(R.string.empty_message_password);
                isValidInput = true
            } else if (!validation.isValidPassword(newPassword)) {
                etnewPassword.error = resources.getString(R.string.text_validation_error_password);
                isValidInput = true
            }
            if (confirmPassword.isEmpty()) {
                etconfirmPassword.error =
                    resources.getString(R.string.empty_message_password);
                isValidInput = true
            } else if (newPassword != confirmPassword) {
                etconfirmPassword.error =
                    resources.getString(R.string.text_validation_error_confirm_password);
                isValidInput = true
            }
            if (!isValidInput) {
                var bundle = Bundle()
                bundle.putString(
                    "name",
                    etfirstName.text.toString() + " " + etlastName.text.toString()
                )
                bundle.putString("emailId", etemailId.text.toString())
                bundle.putString("phoneNumber", etphoneNumber.text.toString())
                var intent = Intent()
                intent.putExtra("name","vijay")
                intent.putExtra("list",bundle)
                Toast.makeText(this, "REGISTERED", Toast.LENGTH_LONG).show()
                setResult(RESULT_OK,intent)
                finish()
            }
        }
    }
}