package com.example.study.es;


import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class EsClient {


    public static void main(String[] args)  throws Exception{

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1",9200,"http"))
        );
/*
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("user1");
        CreateIndexResponse response = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);

        boolean acknowledged = response.isAcknowledged();
        System.out.println(acknowledged);*/

        // 创建索引 - 请求对象
        GetIndexRequest request = new GetIndexRequest();
// 发送请求，获取响应
        GetIndexResponse response = client.indices().get(request,
                RequestOptions.DEFAULT);
// 响应状态
        System.out.println("操作状态 = " + response.getMappings());
        client.close();
    }
}
