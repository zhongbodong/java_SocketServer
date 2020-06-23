/*******************************************************************
 * Copyright (c) 2015-2017 Marktrace
 * Web:  http://www.marktrace.com/
 * Company: �����л�ʿ���ɿƼ����޹�˾
 *
 * Communication protocol interface library of MR7901/MR7914
 * File: RFID_MR7901_DLL
 * Author : zhxx
 * Date   : 2018/02/01
 * Version: V1.0
 *
 *******************************************************************/

#ifndef RFID_MR7901_DLL_H
#define RFID_MR7901_DLL_H

#ifdef __cplusplus
extern "C" {
#endif

#ifdef _WINDOWS
#define RFID_DLL_API __declspec(dllexport)
#else  
#define RFID_DLL_API	
#endif

/* �����붨��: */
#define PARAMETER_ERROR     (-101)      // Function parameter error.
#define INVALID_BUFFER      (-102)      // Receive invalid buffer because CRC16 check error.
#define JSON_PARSING_ERROR  (-103)      // Json string parameter parsing failure.


/**
   ��ȡ�豸�����������, ���������������Ӧ�ĺ���

   @param recv_buffer ������յ��豸�ϱ������ݰ�
   @param recv_len ָ��recv_buffer���ֽ���
   @param json_result (����)����ͷ��Ϣ�������ʽΪJSON��������:
    {
      "cmd" : "0x0001",              // ������
      "seqno" : "00000000",          // ������ˮ��
      "device" : "861694034205896",  // �豸ID
      "version": "3.6"               // �豸����汾��,û����Ϊ��
    }
   @param result_length (����)ָ��json_result �������
   @return �����豸�����������; �����ظ������������붨�壩
*/
RFID_DLL_API int RFID_ReadCmd(const unsigned char *recv_buffer, const int recv_len, 
                              char *json_result, int *result_length);


/**
   �豸��ƽ̨����ע�� cmd: 0x0008

   @param recv_buffer ������յ��豸�ϱ������ݰ�
   @param recv_len ָ��recv_buffer���ֽ���
   @param respond_cmd ƽ̨��Ӧָ� 0x00--ע��ɹ���0xFF--ע��ܾ�
   @param json_str_server_addr ƽ̨��Ӧ���ط�������IP��˿ڣ�ע��ɹ�����Ч������ʽΪJSON�������磺
    {
      "ip" : "218.17.157.214",       // ���ط�����IP
      "port" : 4600,                 // ���ط������˿�
    }
   @param send_buffer (����)ƽ̨Ҫ�·����豸�����ݰ�����������Ϊ250�ֽڣ�
   @return ����Ҫ�·����豸�����ݰ���С; �����ظ������������붨�壩
*/
RFID_DLL_API int RFID_Register(const unsigned char *recv_buffer, const int recv_len, 
                               const unsigned char respond_cmd, 
                               const char *json_str_server_addr, 
                               unsigned char *send_buffer);


/**
   �豸��ƽ̨�����¼ cmd: 0x0001

   @param recv_buffer ������յ��豸�ϱ������ݰ�
   @param recv_len ָ��recv_buffer���ֽ���
   @param respond_cmd ƽ̨��Ӧָ� 0x00--��¼�ɹ���0xFF--��¼�ܾ�
   @param send_buffer (����)ƽ̨Ҫ�·����豸�����ݰ�����������Ϊ250�ֽڣ�
   @return ����Ҫ�·����豸�����ݰ���С; �����ظ������������붨�壩
*/
RFID_DLL_API int RFID_Login(const unsigned char *recv_buffer, const int recv_len, 
                            const unsigned char respond_cmd, 
                            unsigned char *send_buffer);


/**
   �豸��ƽ̨�������� cmd: 0x0003

   @param recv_buffer ������յ��豸�ϱ������ݰ�
   @param recv_len ָ��recv_buffer���ֽ���
   @param respond_cmd ƽ̨��Ӧָ� 0x00--û�в���ָʾ
   @param send_buffer (����)ƽ̨Ҫ�·����豸�����ݰ�����������Ϊ250�ֽڣ�
   @return ����Ҫ�·����豸�����ݰ���С; �����ظ������������붨�壩
*/
RFID_DLL_API int RFID_Heartbeat(const unsigned char *recv_buffer, const int recv_len, 
                                const unsigned char respond_cmd, 
                                unsigned char *send_buffer);


/**
   �豸��ƽ̨���������ϱ� cmd: 0x0004

   @param recv_buffer ������յ��豸�ϱ������ݰ�
   @param recv_len ָ��recv_buffer���ֽ���
   @param send_buffer (����)ƽ̨Ҫ�·����豸�����ݰ�����������Ϊ250�ֽڣ�
   @return ����Ҫ�·����豸�����ݰ���С; �����ظ������������붨�壩
*/
RFID_DLL_API int RFID_DataRecord(const unsigned char *recv_buffer, const int recv_len, 
	                             unsigned char *send_buffer);


/**
   �Խ��յ��ı�ǩ���������� cmd: 0x0004

   @param recv_buffer ������յ��豸�ϱ������ݰ�
   @param recv_len ָ��recv_buffer���ֽ���
   @param json_result (����)������õ��ı�ǩ���ݽ������ʽΪJSON���飬���磺
    {
	  "TAG":[
	  {
        "device": "861694034205706",      //�ɼ����豸ID
        "tagid": "16100001",              //��ǩID
        "tlvtype": "0x8B01",              //TLV����
        "tagtype": "20",                  //��ǩ����
        "antenna": 1,                     //���ߺţ�Ϊ 1,2,3,4 �ֱ��Ӧ�����ϡ������� 4������
        "intensity": -78,                 //�ź�ǿ�ȣ� -78dBm
		"entry": 0,                       //������վ״̬��1������վ��ȡ��Χ�� 0������վ��ȡ��Χ
		"staying": 0,                     //��վͣ����ʶ��1����վͣ����0�����ǻ�վͣ��
        "alarm": 0,                       //����״̬(1byte), 0-����
        "time": "2018-02-26 15:20:40"     //��ǩ��ȡʱ��
      },
	  {......},{......}                   //�˴�ʡ��
      ]
	}
	@param result_length (����)ָ��json_result �������
	@return ���ر�ǩ����; �����ظ������������붨�壩
*/
RFID_DLL_API int RFID_TagDataParse(const unsigned char *recv_buffer, const int recv_len,
                                   char *json_result, int *result_length);


#ifdef __cplusplus
}
#endif

#endif /* RFID_MR7901_DLL_H */