package com.zhou.hikwon.daompl;

import java.util.ArrayList;
import java.util.List;

import com.zhou.hikwon.activity.R;
import com.zhou.hikwon.dao.IProductService;
import com.zhou.hikwon.entity.Product;

public class ProductService implements IProductService{
	//模拟数据
	private Product[] products={
			new Product(
					1,
					"SCC-B1011P/B1311P 1/3 高清彩色摄像机",
					"SCC-B1011P/B1311P",
					"1/3 Super HAD IT CCD,彩色	水平分辨率：540线	最低照度：0.12Lux/(F1.2,15IRE)	背光补偿	工作电压：B1011P为AC220V;	B1211P为AC24V,DC12V",
					null, "Samsung", 1, R.drawable.p1, 1630,
					"kikwon产品"),
			new Product(
					2,
					"DS-7900HF-SH系列嵌入式网络硬盘录像机",
					"DS-7900HF-SH",
					"HDMI与VGA输出分辨率最高均可达1920x1080； 支持HDMI、VGA、CVBS同时输出； 支持HDMI与VGA同源输出； 所有通道支持4CIF实时编码； 采用HIKVISION云台控制协议时候，可通过鼠标选定画面任意区域并进行中心缩放； 支持多画面分割下不同通道并行预览与回放； 支持4/8/16路同步回放 支持标签定义、查询、回放录像文件； 支持回放时对录像场景的自定义区域进行智能搜索； 支持按事件查询、回放、备份录像文件； 支持录像文件倒放功能；",
					null, "Samsung", 1, R.drawable.p2, 2630,
					"kikwon产品"),
			new Product(
					3,
					"加拿大枫叶防盗报警主机",
					"MG6250",
					"无线防盗产品，支持StayD模式，可以本地或远程PC下载设置参数。	此系列适合需要无线连接的场合，比如：别墅，家庭。",
					null, "MAGELLAN 麦杰伦系列", 2, R.drawable.p3, 1633, "kikwon产品"),
			new Product(
					4,
					"加拿大枫叶防盗报警主机",
					"MG6160",
					"无线防盗产品，支持StayD模式，可以本地或远程PC下载设置参数。	此系列适合需要无线连接的场合，比如：别墅，家庭。",
					null, "MAGELLAN 麦杰伦系列", 2, R.drawable.p4, 1636, "kikwon产品"),
			new Product(
					5,
					"EC-200B 电插锁",
					"EC-200B",
					"电控方式：通电上锁，断电开锁 上锁方式：磁感应上锁 电压：12V 工作电流：350mA，单电流 开门方式：180度 重量：0.80kg 锁体尺寸：(200L×35W×38H)mm 门磁信号输出：无 上锁延时：无 配件：扣板、螺丝 磁扣板尺寸：L100×W35×H3mm 相关可选型号：EC-200BL；EC-200B-1；EC-200B-2 可选配件：上夹：ZEC200；下夹：FEC100",
					null, "LCJ", 3, R.drawable.p5, 1650, "kikwon产品"),
			new Product(
					6,
					"EC-200A 电插锁",
					"EC-200A",
					"电控方式：通电上锁，断电开锁 上锁方式：磁感应上锁 电压：12V 工作电流：350mA，单电流 开门方式：180度 重量：0.80kg 锁体尺寸：(200L×35W×38H)mm 门磁信号输出：无 上锁延时：无 配件：扣板、螺丝 磁扣板尺寸：L100×W35×H3mm 相关可选型号：EC-200BL；EC-200B-1；EC-200B-2 可选配件：上夹：ZEC200；下夹：FEC100",
					null, "LCJ", 3, R.drawable.p6, 1730, "kikwon产品")
	};
	
	private List<Product> ps =null; 
	
	public ProductService(){
		ps = new ArrayList<Product>();
		for(Product p:products){
			ps.add(p);
		}
	}
	@Override
	public List<Product> getAll() {
		return this.ps;
	}
	
	
	

	/**
	 * 分页存取数据
	 * params:
	 * pageIndex:代表是第几页(首页从0开始)
	 * pageSize:代表每页多少条记录
	 * return:返回的就是分页之后的数据
	 */
	@Override
	public List<Product> getByPager(int pageIndex, int pageSize) {	
		if (pageIndex<0) pageIndex=0; 
		int totalCount = ps.size();  //总条数
		int pageCount=1; //总页数
		if (totalCount % pageSize==0){
			pageCount = totalCount/pageSize;
		}else{
			pageCount = (totalCount/pageSize)+1;
		}
		
		if (pageIndex>pageCount-1)//说明是最后一页
		{
			//pageIndex = pageCount-1;
			return null;
		}
		
		Object[] source = this.ps.toArray();
		
		 int endIndex=(pageIndex+1)*pageSize;
		if (endIndex>totalCount)
			endIndex=totalCount;
		
	
		List<Product> result = new ArrayList<Product>();
		for(int i=pageIndex*pageSize;i<endIndex;i++){
			result.add((Product)source[i]);
		}
		return result;
	}


	@Override
	public Product getById(int productId) {
		for(Product p:this.ps){
			if (p.getId()==productId){
				return p;
			}
		}	
		return null;
	}

	@Override
	public List<Product> getByName(String name) {
		List<Product> result = new ArrayList<Product>();
		for(Product p:this.ps){
			if (p.getName().indexOf(name)!=-1)
				result.add(p);
		}
		
		return result;
	}

	@Override
	public void Insert(Product p) {
		this.ps.add(p);
	}

	@Override
	public void Modify(Product product) {
		for(int i=0;i<this.ps.size();i++){
			if (product.getId()==ps.get(i).getId()){
				ps.set(i, product);
				break;
			}
		}
	}

	@Override
	public void Del(int id) {
		Product p= this.getById(id);
		if (p!=null)
			this.ps.remove(p);
	}


}
