package com.e.wtc.Service;

import com.e.wtc.entity.Port;

public interface PortService {

    Port createPort(Port port);

    Port getport(int portId);
}
