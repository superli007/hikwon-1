package com.zhou.hikwon.activity;

import com.zhou.hikwon.daompl.ProductService;
import com.zhou.hikwon.entity.Product;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		int id=intent.getIntExtra("id", 0);
		Product product=new Product();
		ProductService pdservice=new ProductService();
		product=pdservice.getById(id);
		setContentView(R.layout.productdetail);
		setReturnImage();
		findAndSetView(product);
		
		
	}
	 //设置返回图标生效
		private void setReturnImage()
		{
			final ImageView imageview=(ImageView) findViewById(R.id.return_image);
			imageview.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v)
				{
					imageview.setBackgroundColor(Color.GREEN);
					finish();
				}});
		}
	private void findAndSetView(Product product)
	{
		TextView nameTv=(TextView)findViewById(R.id.return_title);
//		TextView nameTv=(TextView)findViewById(R.id.product_name);
		ImageView photoIv=(ImageView)findViewById(R.id.product_photo);
		TextView priceTv=(TextView)findViewById(R.id.product_price);
		TextView typeTv=(TextView)findViewById(R.id.product_type);
		TextView overviewTv=(TextView)findViewById(R.id.product_overview);
		
		nameTv.setText(product.getName());
		photoIv.setImageResource(product.getPhoto());
		priceTv.setText("RMB: "+String.valueOf(product.getUnitPrice())+" 元");
		typeTv.setText(product.getType());
		overviewTv.setText(product.getOverview());
	}
	
}
