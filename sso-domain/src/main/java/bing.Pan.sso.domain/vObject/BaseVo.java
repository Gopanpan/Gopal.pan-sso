package bing.Pan.sso.domain.vObject;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @crea : Created by intelliJ IDEA 16.1.3
 * @auth : bing.Pan
 * @mail : 15923508369@163.com
 * @date : 2017/2/9 12:43
 * @desc :
 */
public class BaseVo implements Serializable {

    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("当前页码")
    private int pageIndex;

    @ApiModelProperty("每页数据量")
    private int pageSize;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}