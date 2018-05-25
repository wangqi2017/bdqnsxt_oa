/***
 * 文件处理的公共js文件  author :yiran 
 */

Ext.define('core.utils.Files', {
	alternateClassName : 'files', // hcx add 20140212
    singleton: true, 
    
    //文件上传  hcx 20140606 修改了获取form 内对象的方式
	filesSubmit : function(form,store,type) {
//		var projectid= form.getForm().getRecord().data['project.id']
//		var path = '/projects/' + projectid
//				+ '/files/'+type+'/'
//				+ form.getForm().getRecord().data.id + '/uploadfile';
//		
//		var id=  form.getForm().getRecord().data.id;
		
		var contractinfo = form.getForm().getValues();
		var projectid = contractinfo['project.id'];
		var path = '/projects/' + projectid+ '/files/'+type+'/'+ contractinfo.id + '/uploadfile';
		
		if(null==form.ref || "" == form.ref){
			form.ref = "creatfiles";
		}
		form.getForm().submit({
			clientValidation : false,
			url : path,
			params :{
			  'ref': form.ref
			},
			method : "POST",
			success : function(form, action) {
				Ext.MessageBox.alert('提示',action.result.message)
				store.getProxy().url="/projects/"+projectid+"/files/"+type+"/"+contractinfo.id;
				store.load();
			},
			failure : function(form, action) {
				Ext.MessageBox.alert('失败', '文件上传失败')
			}
		});

	}

})