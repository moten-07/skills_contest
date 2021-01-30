package com.moten.DemoA.aboutIntent;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import okhttp3.OkHttpClient;

public class HttpHelp {
    // 稍微封装一下，用的时候直接调方法就好了

    // 获取服务器地址
    public String getHearUri() {
        return "http://dasai.sdvcst.edu.cn:8080";
    }

    // 1.1 登录，post
    /* 传参示例：
     * "username": "admin",
     * "password": "admin123"
     *
     * Request request = new Request
                    .Builder()
                    .url(help.getHearUri()+help.getGAMImg(pageNum,pageSize,type))
                    .post()
                    .add("username","admin")
                    .add("password","admin123")
                    .build();
     *
     */
    // 会返回 token
    public String PostLogin(){ return "/login"; }

    // 1.2 注册，post
    /* 传参示例：
     * "userName":"cnds",
     * "nickName":"张三",
     * "phonenumber":"18574353453",
     * "sex":"1",
     * "password":"123456"
     */
    public String PostRegister(){
        return "/system/user/register";
    }

    // 2.1 获取引导页图片(get)，需要获得当前页面的页数和每页多少条
    // 仅5条,4和5是同一张图片，不要恐慌,0号图不在返回的数据里
    public String getGAMImg(int pageNum,int pageSize,int type) {
        return "/userinfo/rotation/lists?" +
                "pageNum=" +(pageNum)+
                "&pageSize="+(pageSize)+
                "&type="+type;
    }

    // 3.1 获取主页面轮播图片(get)，需要获得当前页面的页数和每页多少条
    // 仅4条
    // 和上面的只有type有差别,所以合并了


    // 3.2 查询推荐服务(get)，需要获得当前页面的页数和每页多少条
    // 共6条
    // 注："isRecommend": 1, 1 为推荐
    public String getRecommendedUrl(int pageNum,int pageSize) {
        return "/service/service/list?" +
                "pageNum=" +(pageNum)+
                "&pageSize="+(pageSize);
    }

    // 3.3 查询专题新闻列表(get)，需要获得当前页面的页数和每页多少条
    // 3.5 查询所属分类下的新闻列表
    // 疑似文档写重复了（自信点，把疑似去了）,重点是还有写错的
    // pressCategory:35-41
    public String getNewsListUrl(int pageNum,int pageSize,int pressCategory) {
        return "/press/press/list?" +
                "pageNum=" +(pageNum)+
                "&pageSize="+(pageSize)+
                "&pressCategory="+pressCategory;
    }
    public String getNewsLists(int pageNum,int pageSize) {
        return "/press/press/list?" +
                "pageNum=" +(pageNum)+
                "&pageSize="+(pageSize);
    }

    // 3.4 查询新闻分类
    // 共6种
    // 注 dictCode 此字段为分类编号
    public String getNewsType(){ return "/system/dict/data/type/press_category"; }

    // 4.1 查询服务一级分类
    // 共3条
    // 注 dictValue 此字段为分类编号
    public String getServe1(){ return "/system/dict/data/type/sys_service"; }

    // 4.2 查询全部分类
    // 共6条
    // 注 serviceType 此字段为服务分类编号
    public String getAllServe(){ return "/service/service/list"; }

    // 5.1 查询新闻列表
    // 共24条
    public String getNewsList(int pageNum,int pageSize){
        return "/press/press/list?" +
                "pageNum=" +(pageNum)+
                "&pageSize="+(pageSize);
    }

    // 5.2 查询评论列表
    // 共314条（2021.01.22 12：20），有人在上传（12：14），数量一直在增加,不加最后一个参数就可以看见全部
    public String getCommentsList(int pageNum,int pageSize,int pressId){
        return "/press/comments/list?" +
                "pageNum=" +(pageNum)+
                "&pageSize="+(pageSize)+
                "&pressId="+pressId;
    }

    // 5.3 新增评论
    /* 传参示例：
     * "userId": "1",
     * "pressId": "1",
     * "content": "这个新闻是我读过最好的新闻"
     */
    // 此处需要携带 token
    public String postAddComments(){
        return "/press/pressComment";
    }

    // 6.1 查询地铁站首页
    // 大部分地铁……385条都是哪里的啊！……
    public String getSubwayList(int pageNum,int pageSize,String currentName){
        return "/metro/list?" +
                "pageNum=" +(pageNum)+
                "&pageSize="+(pageSize)+
                "&currentName="+currentName;
    }

    // 6.2 查询地铁站详情……个屁，明明是地铁线路，还一共385条
    public String getSubwayOne(int id){
        return "/metro/"+id;
    }

    // 7.1 查询个人基本信息
    // 此处需要携带 token
    public String getUser(int id){
        return "/system/user/"+id;
    }

    // 例外，只要token就可以获取，里面就有上面要的userId，从我师兄那里找到的，文档没有写（也许...大概...应该...吧...）
    public String getUserInfo(){return "/getInfo";}

    public String update(){return "/system/user/updata";}
}
