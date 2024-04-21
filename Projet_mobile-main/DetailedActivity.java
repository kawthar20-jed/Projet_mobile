package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.models.NewProductsModel;
import com.example.myapplication.models.PopularProductsModel;
import com.example.myapplication.models.ShowAllModel;

public class DetailedActivity extends AppCompatActivity {
    ImageView detailedImg;
    TextView rating,name,description,price;
    Button addToCart,buyNow;
    ImageView addItems,removeItems;
    //new Products
    NewProductsModel newProductsModel=null;
    //Popular products
    PopularProductsModel popularProductsModel=null;
    //show All
    ShowAllModel showAllModel=null;
    private FirebaseFirestore firestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        firestore=FirebaseFirestore.getInstance();
        final Object obj=getIntent().getSerializableExtra("detailed");
        if(obj instanceof NewProductsModel){
             newProductsModel=(NewProductsModel) obj;
        }else if(obj instanceof PopularProductsModel){
             popularProductsModel= (PopularProductsModel) obj;

        }else if(obj instanceof ShowAllModel){
            showAllModel= (ShowAllModel) obj;

        }
        detailedImg=findViewById(R.id.detailed_img);
        name=findViewById(R.id.detailed_name);
        rating=findViewById(R.id.rating);
        description=findViewById(R.id.detailed_desc);
        price=findViewById(R.id.detailed_price);
        addToCart=findViewById(R.id.add_to_cart);
        buyNow=findViewById(R.id.buy_now);
        addItems=findViewById(R.id.add_item);
        removeItems=findViewById(R.id.remove_item);

        //new products
        if(newProductsModel!=null){
            Glide.with(getApplicationContext()).load(newProductsModel.getImg_url()).into(detailedImg);
            name.setText(newProductsModel.getName());
            rating.setText(newProductsModel.getRating());
            description.setText(newProductsModel.getDescription());
            price.setText(String.valueOf(newProductsModel.getPrice()));
            name.setText(newProductsModel.getName());
        }
        //Popular products
        if(popularProductsModel!=null){
            Glide.with(getApplicationContext()).load(popularProductsModel.getImg_url()).into(detailedImg);
            name.setText(popularProductsModel.getName());
            rating.setText(popularProductsModel.getRating());
            description.setText(popularProductsModel.getDescription());
            price.setText(String.valueOf(popularProductsModel.getPrice()));
            name.setText(popularProductsModel.getName());
        }
        //Show All products
        if(showAllModel!=null){
            Glide.with(getApplicationContext()).load(showAllModel.getImg_url()).into(detailedImg);
            name.setText(showAllModel.getName());
            rating.setText(showAllModel.getRating());
            description.setText(showAllModel.getDescription());
            price.setText(String.valueOf(showAllModel.getPrice()));
            name.setText(showAllModel.getName());
        }
    }
}