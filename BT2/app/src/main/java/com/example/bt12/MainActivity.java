package com.example.bt12;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;

import android.os.Bundle;

import android.app.AlertDialog;

import android.content.DialogInterface;

import android.view.View;

import android.view.View.OnClickListener;

import android.widget.Button;

import android.widget.CheckBox;

import android.widget.EditText;

import android.widget.ImageButton;

import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    Button btnTT,btnTiep,btnTK;

    ImageButton btnThoat;

    EditText editTen,editSl,editTongKh,editTongKhVip,ediTongTT;

    TextView txtTT;

    CheckBox chkVip;

    DanhSachKhachHang danhsach=new DanhSachKhachHang();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getControls();

        addEvents();
    }

    private void getControls()

    {

        btnTT=(Button) findViewById(R.id.btntinhtt);

        btnTiep=(Button) findViewById(R.id.btntiep);

        btnTK=(Button) findViewById(R.id.btnthongke);

        btnThoat=(ImageButton) findViewById(R.id.imgbtnthoat);

        editTen=(EditText) findViewById(R.id.edittenkh);

        editSl=(EditText) findViewById(R.id.editsoluongsach);

        editTongKh=(EditText) findViewById(R.id.edittongsokh);

        editTongKhVip=(EditText) findViewById(R.id.edittongsokhlavip);

        ediTongTT=(EditText) findViewById(R.id.edittongdt);

        txtTT=(TextView) findViewById(R.id.txtthanhtien);

        chkVip =(CheckBox) findViewById(R.id.chklavip);

    }

    private void addEvents()

    {

        btnTT.setOnClickListener(new ProcessMyEvent());

        btnTiep.setOnClickListener(new ProcessMyEvent());

        btnTK.setOnClickListener(new ProcessMyEvent());

        btnThoat.setOnClickListener(new ProcessMyEvent());

    }

    private void doTinhTien()

    {

        KhachHang kh=new KhachHang();

        kh.setTenKh(editTen.getText()+"");

                kh.setSlmua(Integer.parseInt(editSl.getText()+""));

                        kh.setVip(chkVip.isChecked());

        txtTT.setText(kh.tinhThanhTien()+"");

                danhsach.addKhachHang(kh);

    }

    private void doTiep()

    {

        editTen.setText("");

        editSl.setText("");

        txtTT.setText("");

        editTen.requestFocus();

    }

    private void doThongKe()

    {

        editTongKh.setText(danhsach.tongKhachHang()+"");

                editTongKhVip.setText(danhsach.tongKhachHangVip()+"");

                        ediTongTT.setText(danhsach.tongDoanhThu()+"");

    }

    private void doThoat()

    {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        builder.setTitle("Hỏi chương trình có thoát");

        builder.setMessage("Muốn thoát chuong trình này hả?");

        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();

            }

        });

        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                finish();

            }

        });

        builder.create().show();

    }

    private class ProcessMyEvent implements OnClickListener {

        @Override

        public void onClick(View arg0) {

            switch (arg0.getId()) {

                case R.id.btntinhtt:

                    doTinhTien();

                    break;

                case R.id.btntiep:

                    doTiep();

                    break;

                case R.id.btnthongke:

                    doThongKe();

                    break;

                case R.id.imgbtnthoat:

                    doThoat();

                    break;

            }


        }

    }
}

