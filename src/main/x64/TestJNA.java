package main.x64;

//������λ��������dll�ᱻ���ӣ�����
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;  
import com.sun.jna.ptr.IntByReference; 

public interface TestJNA extends Library {
	
	// ��ȡ������ӿں���
	public int RFID_ReadCmd(byte[] recv_buffer, int recv_len, Pointer json_result, IntByReference resultLength);
	// �豸ע��ӿں���
	public int RFID_Register(byte[] recv_buffer, int recv_len, byte respond_cmd, String json_str_server_addr, byte[] send_buffer);
	// �豸��¼�ӿں���
	public int RFID_Login(byte[] recv_buffer, int recv_len, byte respond_cmd, byte[] send_buffer);
	// �豸�����ӿں���
	public int RFID_Heartbeat(byte[] recv_buffer, int recv_len, byte respond_cmd, byte[] send_buffer);
	// �豸�����ϱ��ӿں���
	public int RFID_DataRecord(byte[] recv_buffer, int recv_len, byte[] send_buffer);
	// �����豸�ϱ��ı�ǩ����
	public int RFID_TagDataParse(byte[] recv_buffer, int recv_len, Pointer json_result, IntByReference resultLength);

	String filePath = "/java/"+ "libRFID_MR7901_DLL_LINUX.so";
	// ����dll
	TestJNA INSTANCE = (TestJNA) Native.loadLibrary(filePath, TestJNA.class);
	
}