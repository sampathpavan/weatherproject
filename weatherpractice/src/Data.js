import React from 'react'

const Data = (props) => {
    const { latitude, longitude, temperature, city, updateFrequency } = props
    return (
        <div>
            <h2 >Latitude: {latitude}</h2>
            <h2 >Longitude: {longitude}</h2>
            <h2 className='violet'>Temperature: {temperature}°C</h2>
            <h2 className='green'>City: {city}</h2>
            <h2 className='violet'>Update Frequency: {updateFrequency} minute(s)</h2>
        </div>
    )
}
export default Data