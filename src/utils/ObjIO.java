package utils;

import java.io.*;
import java.util.*;

public class ObjIO<T extends Serializable> {
	
	private final static String OUT_OF_BOUNDS_ERR_MSG = "Index must be between 0 and size-1";
	
	File f;
	ObjectInputStream reader;
	ObjectOutputStream writer;
	int size;
	
	public ObjIO(File f) {
		this.f = f;
		this.size = calcSize();
	}
	
	private void newWriter() throws IOException {
		writer = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(f)));
	}
	
	private void newReader() throws IOException {
		if (f.exists())
				reader = new ObjectInputStream(
						new BufferedInputStream(
								new FileInputStream(f)));
	}
	
	private void closeWriterUnchecked() {
		try {
			writer.close();
		}
		catch (IOException e) {}
	}
	
	private void closeReaderUnchecked() {
		try {
			reader.close();
		}
		catch (IOException e) {}
	}
	
	private int calcSize() {
		int size = 0;
		try {
			newReader();
			boolean eof = false;
			while (!eof) {
				try {
					reader.readObject();
					size++;
				}
				catch (EOFException e) { eof = true; }
			}
			reader.close();
		}
		catch (NullPointerException | ClassNotFoundException | IOException e) {
			size = -1;
			closeReaderUnchecked();
		}
		return size;
	}
	
	@SuppressWarnings("unchecked")
	public T read() {
		
		T readed;
		try {
			newReader();
			readed = (T) reader.readObject();
			reader.close();
		}
		catch (NullPointerException | ClassNotFoundException | IOException e) {
			readed = null;
			closeReaderUnchecked();
		}
		return readed;
	}
	/* PROVA DI FUNZ PER APRIRE FILE CON SERIALE VECCHIO //NON FUNZIONA\\
	@SuppressWarnings("unchecked")
	public T readAnyVersion(long newSerial) {
		
		T readed = null;
		try {
			newReader();
			readed = (T) reader.readObject();
			reader.close();
		}
		catch (InvalidClassException e1) {
			
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (changeFileSerial(newSerial)) {
				System.out.println("cambiato");
				return read();
			}
		}
		catch (NullPointerException | ClassNotFoundException | IOException e2) {}
		
		return readed;
	}
	
	private boolean changeFileSerial(long newSerial) {
		try {
			DataInputStream in = new DataInputStream ( new BufferedInputStream (new FileInputStream(f)));
			
			String utf = in.readUTF();
			long oldSerial = in.readLong();
			
			Vector<Byte> remainingBytes = new Vector<Byte>();
			boolean EOF = false;
			do {
				try {
					remainingBytes.add(in.readByte());
				}
				catch (EOFException e) {
					EOF = true;
				}
			} while (!EOF);
			
			in.close();
			
			DataOutputStream out = new DataOutputStream ( new BufferedOutputStream (new FileOutputStream(f)));
			
			out.writeUTF(utf);
			out.writeLong(newSerial);
			for (byte b: remainingBytes)
				out.writeByte(b);
			
			out.close();
		}
		catch (IOException e) {
			return false;
		}
		
		return true;
	}
	*/
	@SuppressWarnings("unchecked")
	public T[] readAll(T[] array) {
		Vector<T> objVect = new Vector<T>();
		try {
			newReader();
			boolean eof = false;
			while (!eof) {
				try {
					objVect.add((T) reader.readObject());
				}
				catch (EOFException e) { eof = true; }
			}
		}
		catch (NullPointerException | ClassNotFoundException | IOException e) {
			closeReaderUnchecked();
			return null;
		}
		return objVect.toArray(array);
	}
	
	@SuppressWarnings("unchecked")
	public T readAt(int index) {
		if (index >= size || index < 0) throw new IllegalArgumentException(OUT_OF_BOUNDS_ERR_MSG);
		T readed;
		try {
			newReader();
			for (int i=0; i<index; i++) { reader.readObject(); }
			readed = (T) reader.readObject();
			reader.close();
		}
		catch (NullPointerException | ClassNotFoundException | IOException e) {
			closeReaderUnchecked();
			return null;
		}
		return readed;
	}
	
	public boolean write(T obj) {
		try {
			newWriter();
			writer.writeObject(obj);
			writer.close();
			return true;
		}
		catch (IOException e) {
			closeWriterUnchecked();
			return false;
		}
	}
	
	public boolean writeAll(Collection<T> objColl) {
		Iterator<T> iter = objColl.iterator();
		try {
			this.size = 0;
			newWriter();
			while (iter.hasNext()) {
				writer.writeObject(iter.next());
				this.size++;
			}
			writer.close();
			return true;
		}
		catch (IOException e) {
			closeWriterUnchecked();
			return false;
		}
	}
	
	public boolean writeAll(T[] objArray) {
		try {
			newWriter();
			this.size = 0;
			for (T obj: objArray) {
				writer.writeObject(obj);
				this.size++;
			}
			writer.close();
			return true;
		}
		catch (IOException e) {
			closeWriterUnchecked();
			return false;
		}
	}
	
	public boolean contains(T obj) {
		boolean contained = false;
		try {
			newReader();
			boolean eof = false;
			while (!eof) {
				try {
					if (reader.readObject().equals(obj)) {
						contained = true;
						break;
					}
				}
				catch (EOFException e) {
					eof = true;
				}
			}
		}
		catch (NullPointerException | ClassNotFoundException | IOException e) {}
		
		closeReaderUnchecked();
		return contained;
	}
	
	public int size() {
		return this.size;
	}
	
	public String fileName () {
		return f.getName();
	}

}
