package com.github.xuejike.springboot.jkfaststart.common;

import com.bidanet.bdcms.core.bean.AjaxCallBack;
import com.bidanet.bdcms.core.vo.Page;
import lombok.Data;

import java.util.List;

@Data
public class AjaxPage<T> extends AjaxCallBack {
    private Long total;
    private List<T> rows;

    public static <T> AjaxPage<T> success(Page<T> page){
        AjaxPage<T> ajaxPage = new AjaxPage<>();
        ajaxPage.setStatusCode(AjaxPage.STATUS_OK);
        ajaxPage.setRows(page.getList());
        ajaxPage.setTotal(page.getTotal());
        return ajaxPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
