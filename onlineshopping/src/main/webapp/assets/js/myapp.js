$(function() {
	//solving the active menu problems
  switch(menu){
	case 'About': 
		$('#about').addClass('active');
		break;
	case 'Contact':
		$('#contact').addClass('active');
		break;
	case 'Products':
		$('#products').addClass('active');
		break;
	default:
		if($('#home')) { $('#products').addClass('active');}break;

		$('#products').addClass('active');
	    $('#a_'+menu).addClass('active');
    	break;

	}
  
  
  

  

  const $table = $('#productlisttable');
  
  
  if($table.length){
	  
	  var jsonURL = '';
	  
	  if(window.categoryId==''){
		  jsonURL = window.contextRoot + '/json/data/all/products';
	  }else{
		  jsonURL = window.contextRoot + '/json/data/category/'+window.categoryId+'/products';

	  }
	  
	  
	  $table.DataTable({
		  lengthMenu: [[3,5,10,-1], ['3 records', '5 records' , '10 records', 'All']],
		  pageLength:5,
		  ajax:{
			  url: jsonURL,
			  dataSrc: ''
		  },
		  columns: [
			  {
				data: 'code',
				mRender: function(data, type, row) {
					return '<img src="'+window.contextRoot+'/resources/img/'+data+'.png" class="dataTableImage" />';
				}
			  },
			  {
				  data: 'name'
			  },
			  {
				  data: 'brand'
			  },
			  {
				  data: 'unitPrice',
				  mRender: function(data, type, row) {
					  return '&#8377; ' + data;
				  }
			  },
			  {
				  data: 'quantity',
				  mRender: function(data, type, row) {
					  if(data<1){
						  return '<span style="color:red">out of stock</span>'
					  }
					  
					  return data;
				  }
			  },
			  {
				  data: 'id',
				  bSortable: false,
				  mRender: function(data, type, row) {
					  var str = '';
					  str += '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-secondary">View</a>&#160;';

					  if(row.quantity<1){
						  str += '<a href="javascript:void(0)" class="btn btn-success disabled">Add To Cart</a>';

					  }else{
						  str += '<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success">Add To Cart</a>';

					  }
					  

					  return str;
				  }
			  }
		  ]
	  })
  }
  
  
});
		












