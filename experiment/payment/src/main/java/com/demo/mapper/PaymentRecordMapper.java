package com.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demo.model.dto.ChartDo;
import com.demo.model.dto.DayPayData;
import com.demo.model.dto.MonthPayData;
import com.demo.model.dto.PaymentRecordDto;
import com.demo.model.entity.PaymentRecord;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 收支记录表 Mapper 接口
 * </p>
 *
 * @author MixJade
 * @since 2024-12-19
 */
@Mapper
public interface PaymentRecordMapper extends BaseMapper<PaymentRecord> {

    IPage<PaymentRecordDto> getByPage(IPage<PaymentRecordDto> page, Integer bigType, String beginDate, String endDate);

    List<MonthPayData> getMonthDataByYear(Integer year);

    List<DayPayData> getDayDataByMonth(Integer year, Integer month);

    List<ChartDo> getPieChart(Integer year, Integer month);

    BigDecimal getPayByMonth(Integer year, Integer month);
}
