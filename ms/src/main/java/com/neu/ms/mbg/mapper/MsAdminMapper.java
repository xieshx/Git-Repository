package com.neu.ms.mbg.mapper;

import com.neu.ms.mbg.model.MsAdmin;
import com.neu.ms.mbg.model.MsAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MsAdminMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_admin
     *
     * @mbg.generated Sat Jan 30 18:45:22 CST 2021
     */
    long countByExample(MsAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_admin
     *
     * @mbg.generated Sat Jan 30 18:45:22 CST 2021
     */
    int deleteByExample(MsAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_admin
     *
     * @mbg.generated Sat Jan 30 18:45:22 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_admin
     *
     * @mbg.generated Sat Jan 30 18:45:22 CST 2021
     */
    int insert(MsAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_admin
     *
     * @mbg.generated Sat Jan 30 18:45:22 CST 2021
     */
    int insertSelective(MsAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_admin
     *
     * @mbg.generated Sat Jan 30 18:45:22 CST 2021
     */
    List<MsAdmin> selectByExample(MsAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_admin
     *
     * @mbg.generated Sat Jan 30 18:45:22 CST 2021
     */
    MsAdmin selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_admin
     *
     * @mbg.generated Sat Jan 30 18:45:22 CST 2021
     */
    int updateByExampleSelective(@Param("record") MsAdmin record, @Param("example") MsAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_admin
     *
     * @mbg.generated Sat Jan 30 18:45:22 CST 2021
     */
    int updateByExample(@Param("record") MsAdmin record, @Param("example") MsAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_admin
     *
     * @mbg.generated Sat Jan 30 18:45:22 CST 2021
     */
    int updateByPrimaryKeySelective(MsAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_admin
     *
     * @mbg.generated Sat Jan 30 18:45:22 CST 2021
     */
    int updateByPrimaryKey(MsAdmin record);
}